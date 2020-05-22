Sep 8, 2012 2:55:37 PM org.springframework.context.support.AbstractApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@5d3ad33d: startup date [Sat Sep 08 14:55:37 MSK 2012]; root of context hierarchy
Sep 8, 2012 2:55:37 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring-context.xml]
Sep 8, 2012 2:55:37 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@6cb32ed4: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.annotation.internalPersistenceAnnotationProcessor,usersHome,usersService,dataSource,sessionFactory,org.springframework.aop.config.internalAutoProxyCreator,org.springframework.transaction.annotation.AnnotationTransactionAttributeSource#0,org.springframework.transaction.interceptor.TransactionInterceptor#0,org.springframework.transaction.config.internalTransactionAdvisor,transactionManager,org.springframework.context.annotation.ConfigurationClassPostProcessor$ImportAwareBeanPostProcessor#0]; root of factory hierarchy
Sep 8, 2012 2:55:37 PM org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory initDatabase
INFO: Creating embedded database 'dataSource'
Sep 8, 2012 2:55:38 PM org.hibernate.annotations.common.Version <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {4.0.1.Final}
Sep 8, 2012 2:55:38 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate Core {4.1.4.Final}
Sep 8, 2012 2:55:38 PM org.hibernate.cfg.Environment <clinit>
INFO: HHH000206: hibernate.properties not found
Sep 8, 2012 2:55:38 PM org.hibernate.cfg.Environment buildBytecodeProvider
INFO: HHH000021: Bytecode provider name : javassist
Sep 8, 2012 2:55:38 PM org.hibernate.cfg.Configuration configure
INFO: HHH000044: Configuring from URL: file:/home/gr/dev/target/classes/hibernate.cfg.xml
Sep 8, 2012 2:55:38 PM org.hibernate.internal.util.xml.DTDEntityResolver resolveEntity
WARN: HHH000223: Recognized obsolete hibernate namespace http://hibernate.sourceforge.net/. Use namespace http://www.hibernate.org/dtd/ instead. Refer to Hibernate 3.6 Migration Guide!
Sep 8, 2012 2:55:38 PM org.hibernate.cfg.Configuration doConfigure
INFO: HHH000041: Configured SessionFactory: null
Sep 8, 2012 2:55:38 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
Sep 8, 2012 2:55:38 PM org.hibernate.engine.jdbc.internal.LobCreatorBuilder useContextualLobCreation
INFO: HHH000423: Disabling contextual LOB creation as JDBC driver reported JDBC version [3] less than 4
Sep 8, 2012 2:55:38 PM org.hibernate.engine.transaction.internal.TransactionFactoryInitiator initiateService
INFO: HHH000399: Using default transaction strategy (direct JDBC transactions)
Sep 8, 2012 2:55:38 PM org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory <init>
INFO: HHH000397: Using ASTQueryTranslatorFactory
Sep 8, 2012 2:55:38 PM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000228: Running hbm2ddl schema update
Sep 8, 2012 2:55:38 PM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000102: Fetching database metadata
Sep 8, 2012 2:55:38 PM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000396: Updating schema
Sep 8, 2012 2:55:38 PM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: UsersEntity
Sep 8, 2012 2:55:38 PM org.hibernate.tool.hbm2ddl.DatabaseMetadata getTableMetadata
INFO: HHH000262: Table not found: UsersEntity
Sep 8, 2012 2:55:39 PM org.hibernate.tool.hbm2ddl.SchemaUpdate execute
INFO: HHH000232: Schema update complete
Sep 8, 2012 2:55:39 PM org.springframework.orm.hibernate4.HibernateTransactionManager afterPropertiesSet
INFO: Using DataSource [org.springframework.jdbc.datasource.SimpleDriverDataSource@79ef3ccd] of Hibernate SessionFactory for HibernateTransactionManager
Hibernate: insert into UsersEntity (id, enable, login, name) values (null, ?, ?, ?)
RemoteTestNG finishing: 2868 ms