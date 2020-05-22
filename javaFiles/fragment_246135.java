public interface Createable
{
    public void create();
}

class EnvA implements Createable {...}

class EnvB implements Createable {...}

...

Createable obj = null;
if(itisEnvB) {
    obj = new EnvA ();
} else {
    obj = new EnvB ();
}
obj.create();