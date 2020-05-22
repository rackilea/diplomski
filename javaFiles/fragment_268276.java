String[] str = {};
Class cls = Class.forName(packClassName);        
Method thisMethod = cls.getMethod("main", String[].class);        
thisMethod.setAccessible(true);        

thisMethod.invoke(null, new Object[]{str});//ver 1
thisMethod.invoke(null, (Object)str);//ver 2