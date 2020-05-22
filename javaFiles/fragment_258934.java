import java.util.ArrayList;
import java.util.List;

public class ogr
{

    public static void main(String[] args) throws InterruptedException {
        final PositionHolder holder = new PositionHolder();
        final List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            holder.setPosition(i);
            Thread t = new Thread() {

                @Override
                public void run() {
                    data.add(holder.getPosition());
                }
            };

            t.start();
            t.join();
        }

        for (int i : data) {
            System.out.println(i);
        }
    }
}

class PositionHolder
{

    int position = 0;

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }
}