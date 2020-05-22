public class CustomPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
          /**  
        * Map that hold all the properties.
             */
        private Map<String, String> propertiesMap; 
        /**
         * Iterate through all the Propery keys and build a Map, resolve all the nested values before beuilding the map.
         */
        @Override
        protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
            super.processProperties(beanFactory, props);

            propertiesMap = new HashMap<String, String>();
            for (Object key : props.keySet()) {
                String keyStr = key.toString();
                String valueStr = prop.getProperty(keyStr);
                propertiesMap.put(keyStr.trim(), valueStr.trim());
            }
        } 


        public String getProperty(String name) {
            return propertiesMap.get(name).toString();
        }