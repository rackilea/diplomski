int size = movies.size();

int index=0;
while(index<size)
{
    removeMovie(movies, movies.get(index));

    index++;
}