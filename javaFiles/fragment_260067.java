package relive;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class answer_a {

    public static void main(String[] args) {
        try{
            Class<?> clazz = Class.forName("relive.ProjectAccount");
            Constructor<?> constr = clazz.getDeclaredConstructor(null);
            Method mets = clazz.getDeclaredMethod("toString", null);
            Object obj = constr.newInstance(new Object[] {});

            //Print Default values
            System.out.println(mets.invoke(obj, null));

            String mod_projectAccountID= "ORPT-BT-EMP-DEV";
            double mod_budget = 2200000.0;
            int mod_noOfProjects = 20;

            //Method that accesses the Fields and modifies them with the new variables

            Field [] fields = clazz.getDeclaredFields();
            for(int y=0; y<fields.length; y++){
                fields[y].setAccessible(true);

                if(fields[y].getName() == "projectAccountID"){
                    fields[y].set(obj, mod_projectAccountID);
                }
                else if(fields[y].getType().getSimpleName() == "double"){
                    fields[y].set(obj, mod_budget);
                }
                else if (fields[y].getType().getSimpleName() == "int"){
                    fields[y].set(obj, mod_noOfProjects);
                }
            }

            System.out.println(mets.invoke(obj, null));

        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e){
            e.printStackTrace();
        }
    }

}