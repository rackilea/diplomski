import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class SimpleLocation {

    private double x;
    private double y;
    private double z;
    private Vector direction;
    private String worldname;

    public SimpleLocation(String worldname, double x, double y, double z, Vector direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
        this.worldname = worldname;
    }

    public SimpleLocation(Location loc) {
        this.x = loc.getX();
        this.y = loc.getY();
        this.z = loc.getZ();
        this.direction = loc.getDirection();
        if (loc.getWorld() != null) {
            this.worldname = loc.getWorld().getName();
        } else {
            throw new NullPointerException("The locations world is null!");
        }
    }

    public Location getLocation() {
        return new Location(Bukkit.getWorld(worldname), x, y, z).setDirection(direction);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public String getWorldname() {
        return worldname;
    }

    public void setWorldname(String worldname) {
        this.worldname = worldname;
    }

}