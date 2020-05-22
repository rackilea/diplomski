bytes = [3.14].pack('D').each_byte.map { |byte| byte.ord.to_s(2) }
=> ["11111", "10000101", "11101011", "1010001", "10111000", "11110", "1001",
    "1000000"]

bytes.map { |byte| byte.to_i(2).chr }.join.unpack('D')
=> [3.14]