import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomInRanges
{
    private final List<Integer> range = new ArrayList<>();

    RandomInRanges(int min, int max)
    {
        this.addRange(min, max);
    }

    final void addRange(int min, int max)
    {
        for(int i = min; i <= max; i++)
        {
            this.range.add(i);
        }
    }

    int getRandom()
    {
        return this.range.get(new Random().nextInt(this.range.size()));
    }

    public static void main(String[] args)
    {
        RandomInRanges rir = new RandomInRanges(1, 10);
        rir.addRange(50, 60);
        System.out.println(rir.getRandom());
    }
}