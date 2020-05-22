Handler h = new StreamHandler(System.out, formatter)
    {
        public void publish(LogRecord record)
        {
            if(record == null)
                return;
            super.publish(record);
            super.flush();
        }
    };