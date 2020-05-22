/**
 * 
 */
package com.stackoverflow.common.util.schema;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Environment;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.hibernate.jpa.AvailableSettings;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 *
 */
public class JPA21Hibernate5ExportSchema {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String JDBC_URL = "jdbc:h2:mem:export;DB_CLOSE_DELAY=-1";
    private static final String JDBC_USERNAME = "sa";
    private static final String JDBC_PASSWORD = "";

    /**
     * 
     */
    public JPA21Hibernate5ExportSchema() {

    }

    public static void main(String[] args) {
        try {
            JPA21Hibernate5ExportSchema hes = new JPA21Hibernate5ExportSchema();
            hes.export(args[0], args[1]);
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public void export(String persistenceUnitName, String sqlFile) throws IOException, ClassNotFoundException {

        final BootstrapServiceRegistry bsr = new BootstrapServiceRegistryBuilder().build();
        final MetadataSources metadataSources = new MetadataSources(bsr);

        final StandardServiceRegistryBuilder srrBuilder = new StandardServiceRegistryBuilder(bsr)
                .applySetting(Environment.CONNECTION_PROVIDER, DriverManagerConnectionProviderImpl.class.getName())
                .applySetting(Environment.DIALECT, MySQL5InnoDBDialect.class.getName())
                .applySetting(Environment.URL, JDBC_URL).applySetting(Environment.USER, JDBC_USERNAME)
                .applySetting(Environment.PASS, JDBC_PASSWORD);

        // Use the persistence metamodel to retrieve the Entities classes
        Metamodel metamodel = this.getMetamodel(persistenceUnitName);
        for (final ManagedType<?> managedType : metamodel.getManagedTypes()) {
            metadataSources.addAnnotatedClass(managedType.getJavaType());
        }

        final StandardServiceRegistry ssr = (StandardServiceRegistry) srrBuilder.build();
        final MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder(ssr);

        final SchemaExport exporter = new SchemaExport((MetadataImplementor) metadataBuilder.build());
        exporter.setOutputFile(sqlFile);
        exporter.setDelimiter(";");
        exporter.setFormat(true);
        exporter.create(false, true);

    }

    /**
     * Retrieve the JPA metamodel from the persistence unit name
     * 
     * @param persistenceUnitName
     * @return
     */
    private Metamodel getMetamodel(String persistenceUnitName) {
        final Properties persistenceProperties = new Properties();
        persistenceProperties.setProperty(AvailableSettings.JDBC_DRIVER, JDBC_DRIVER);
        persistenceProperties.setProperty(AvailableSettings.JDBC_URL, JDBC_URL);
        persistenceProperties.setProperty(AvailableSettings.JDBC_USER, "sa");
        persistenceProperties.setProperty(AvailableSettings.JDBC_PASSWORD, "");
        persistenceProperties.setProperty(org.hibernate.cfg.AvailableSettings.DIALECT,
                MySQL5InnoDBDialect.class.getName());

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName,
                persistenceProperties);
        return emf.getMetamodel();
    }

}