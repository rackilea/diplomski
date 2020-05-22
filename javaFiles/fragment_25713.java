import java.lang.reflect.*;

public class Me {
    final String name;

    Me(String name) {
        this.name = name;
    }

    class InnerMe {     
        String whoAreYou() {
            return name;
        }
    }   

    InnerMe innerSelf() {
        return new InnerMe();
    }

    public static void main(String args[]) throws Exception {
        final Me me = new Me("Just the old me!");
        final InnerMe innerMe = me.innerSelf();
        System.out.println(innerMe.whoAreYou()); // "Just the old me!"
        Field outerThis = innerMe.getClass().getDeclaredFields()[0];
        outerThis.setAccessible(true);
        outerThis.set(innerMe, new Me("New and improved me!"));
        System.out.println(innerMe.whoAreYou()); // "New and improved me!"
    }

}