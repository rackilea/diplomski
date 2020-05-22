public class ChangeLocale implements LocaleProvider {  

        private String lan;  

        public String getLan() {  
            return lan;  
        }  
        public void setLan(String lan) {  
            this.lan = lan;  
        }  
        public Locale getLocale() {  

            Locale locale=null;
            // Switch language between Chinese and English  
            if("chinese".equals(lan)){  
                locale=new Locale("zh", "cn");  
            }else if("english".equals(lan)){  
                locale=new Locale("en", "US");  
            }  
            return locale;  
        }  
    }