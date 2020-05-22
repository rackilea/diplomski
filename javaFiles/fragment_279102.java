SparkSession session = SparkSession.builder().config(conf).getOrCreate();
        Dataset<Row> ds = session.read().text("<some path>");
        Encoder<Employee> employeeEncode = Encoders.bean(Employee.class);
        ds.map(new MapFunction<Row, Employee>() {
            @Override
            public Employee call(Row value) throws Exception {
                return new Employee(value.getString(0).split(","));
            }
        }, employeeEncode).printSchema();