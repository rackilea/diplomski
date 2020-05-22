package stackoverflow;

import java.nio.ByteBuffer;

import org.openjdk.jol.info.GraphLayout;

public class EfficientByteArrayStorage
{
    public static void main(String[] args)
    {
        showExampleUsage();
        anaylyzeMemoryFootprint();
    }

    private static void anaylyzeMemoryFootprint()
    {
        testMemoryFootprint(10, 1000);
        testMemoryFootprint(100, 100);
        testMemoryFootprint(1000, 10);
    }

    private static void testMemoryFootprint(int rows, int cols)
    {
        System.out.println("For " + rows + " rows and " + cols + " columns:");

        ByteArray2D b0 = new SimpleByteArray2D(rows, cols);
        GraphLayout g0 = GraphLayout.parseInstance(b0);
        System.out.println("Total size for SimpleByteArray2D : " + g0.totalSize());
        //System.out.println(g0.toFootprint());

        ByteArray2D b1 = new CompactByteArray2D(rows, cols);
        GraphLayout g1 = GraphLayout.parseInstance(b1);
        System.out.println("Total size for CompactByteArray2D: " + g1.totalSize());
        //System.out.println(g1.toFootprint());
    }

    // Shows an example of how to use the different implementations
    private static void showExampleUsage()
    {
        System.out.println("Using a SimpleByteArray2D");
        ByteArray2D b0 = new SimpleByteArray2D(10, 10);
        exampleUsage(b0);

        System.out.println("Using a CompactByteArray2D");
        ByteArray2D b1 = new CompactByteArray2D(10, 10);
        exampleUsage(b1);
    }

    private static void exampleUsage(ByteArray2D byteArray2D)
    {
        // Reading elements of the array
        System.out.println(byteArray2D.get(2, 4));

        // Writing elements of the array
        byteArray2D.set(2, 4, (byte)123);
        System.out.println(byteArray2D.get(2, 4));

        // Bulk access to rows
        ByteBuffer row = byteArray2D.getRow(2);
        for (int c = 0; c < row.capacity(); c++)
        {
            System.out.println(row.get(c));
        }

        // (Commented out for this MCVE: Writing one row to a file)
        /*/
        try (FileChannel fileChannel = 
            new FileOutputStream(new File("example.dat")).getChannel())
        {
            fileChannel.write(byteArray2D.getRow(2));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //*/
    }

}


interface ByteArray2D 
{
    int getNumRows();
    int getNumColumns();
    byte get(int r, int c);
    void set(int r, int c, byte b);

    // Bulk access to rows, for convenience and efficiency
    ByteBuffer getRow(int row);
}

class SimpleByteArray2D implements ByteArray2D 
{
    private final int rows;
    private final int cols;
    private final byte array[][];

    public SimpleByteArray2D(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.array = new byte[rows][cols];
    }

    @Override
    public int getNumRows()
    {
        return rows;
    }

    @Override
    public int getNumColumns()
    {
        return cols;
    }

    @Override
    public byte get(int r, int c)
    {
        return array[r][c];
    }

    @Override
    public void set(int r, int c, byte b)
    {
        array[r][c] = b;
    }

    @Override
    public ByteBuffer getRow(int row)
    {
        return ByteBuffer.wrap(array[row]);
    }
}

class CompactByteArray2D implements ByteArray2D
{
    private final int rows;
    private final int cols;
    private final ByteBuffer buffer;

    public CompactByteArray2D(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.buffer = ByteBuffer.allocate(rows * cols);
    }

    @Override
    public int getNumRows()
    {
        return rows;
    }

    @Override
    public int getNumColumns()
    {
        return cols;
    }

    @Override
    public byte get(int r, int c)
    {
        return buffer.get(r * cols + c);
    }

    @Override
    public void set(int r, int c, byte b)
    {
        buffer.put(r * cols + c, b);
    }

    @Override
    public ByteBuffer getRow(int row)
    {
        ByteBuffer r = buffer.slice();
        r.position(row * cols);
        r.limit(row * cols + cols);
        return r.slice();
    }
}