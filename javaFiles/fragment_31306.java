107     // 'hibernate.temp.use_jdbc_metadata_defaults' is a temporary magic value.
108     // The need for it is intended to be alleviated with future development, thus it is
109     // not defined as an Environment constant...
110     //
111     // it is used to control whether we should consult the JDBC metadata to determine
112     // certain Settings default values; it is useful to *not* do this when the database
113     // may not be available (mainly in tools usage).
114     boolean useJdbcMetadata = ConfigurationHelper.getBoolean( "hibernate.temp.use_jdbc_metadata_defaults", configValues, true );