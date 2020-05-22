# You'll probably read each_line from a file, and get a bunch of strings like:
from_file =  0001111110000101111010110101000110111000000111100000100101000000

# If you've no byte separator in your file, the trick is to scan the string
# for 8 digits groups, that is bytes:
bytes = from_file.scan(/\d{8}/)
=>["00011111", "10000101", "11101011", "01010001", "10111000", "00011110",
   "00001001", "01000000"]

# Then, we can go on unpacking:
bytes.map { |byte| byte.to_i(2).chr }.join.unpack('D')
=> [3.14]