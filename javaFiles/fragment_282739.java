int count = 0;
while (inputStream.hasNextDouble ()) {
        count ++;
        x = inputStream.nextDouble ();
        y += x;
        System.out.println (x);
}
// divide y by count for the mean