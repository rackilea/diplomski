byte[] one = getBytesForOne();
byte[] two = getBytesForTwo();
byte[] combined = new byte[one.length + two.length];

for (int i = 0; i < combined.length; ++i)
{
    combined[i] = i < one.length ? one[i] : two[i - one.length];
}