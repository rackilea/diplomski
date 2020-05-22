String line = buffRead.readLine();

while (line.equals("0") == false && i < 100) {
    i++;
    line = buffRead.readLine();
    nums[i] = Integer.parseInt(line);
}