cd src
for F in R.java Maze.java EmptyActivity.java; do
  javac -d ../build/classes $P/$F 2> ~/tmp/javac.out
  echo -en "\033[1m"; cat ~/tmp/javac.out; echo -en "\033[0m"
  grep error ~/tmp/javac.out && exit
done
cd ..