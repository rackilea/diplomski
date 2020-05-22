permute({A,B,C}, '')
                   /           |           \
 permute({B,C}, 'A')  permute({A,C}, 'B')   permute({A,B}, 'C')   
                          /          \
               permute({A}, 'BC')    permute({C}, 'BA')
                       |
               permute({}, 'BCA')<---BASE CASE, print 'BCA'