long startTime = System.currentTimeMillis();
int[][] multi = new int[5][10];

for(int i = 0; i < multi.length; i++)
{
    for(int j = 0; j < multi[i].length; j++)
    {
        multi[i][j] = Math.Random(); //You'll need to add modifiers to this depending on what your range of random numbers is.
    }
}

//If you still want to call doSomething(), here is the place to call it.

long runTime = System.currentTimeMillis() - startTime;
//And print to console.
System.out.println("This ran in " + runTime + " miliseconds");