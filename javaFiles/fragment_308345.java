public class SurfaceToAirLauncher extends Fighter {
    @Override public boolean isGround () {
        // missile launcher is on the ground
        return true; 
    }
    @Override public boolean canAttack (Fighter target) {
        // we can only attack air targets
        return (target != null && !target.isGround());
    }
}

public class Dragon extends Fighter {
    @Override public boolean isGround () {
        // dragons are in the air
        return false; 
    }
    @Override public boolean canAttack (Fighter target) {
        // dragons can attack every target.
        return (target != null);
    }
}

public class Knight extends Fighter {
    @Override public boolean isGround () {
        // knights are on the ground
        return true; 
    }
    @Override public boolean canAttack (Fighter target) {
        // knights can only attack dragons
        return (target != null && target instanceof Dragon);
    }
}