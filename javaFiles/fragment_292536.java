String line = buffRead.readLine();

while (line.equals("0") == false && i < 100) {
    nums[i] = Integer.parseInt(line);
    i++;
    line = buffRead.readLine();
}