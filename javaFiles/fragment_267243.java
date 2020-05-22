public abstract class Enemy {
    ...
    public void render() {
        if(firstEnemy) {
            for(int i =  0; i > x.size(); i++) {
                doRender(i);
            }
        }
    }
    public abstract void doRender(int i);
}

public class E0 extends Enemy {
    ...
    public abstract void doRender(int i) {
        ... // Do the work for a single step of the loop in E0
    }
}
public class E1 extends Enemy {
    ...
    public abstract void doRender(int i) {
        ... // Do the work for a single step of the loop in E1
    }
}
... // And so on