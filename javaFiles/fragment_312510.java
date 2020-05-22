.ldc:
incl %esi # increment the variable pc, first half of pc += 2;
movb %ecx, program(%esi) # load byte after instruction
movl %eax, constants(,%ebx,4) # load constant from pool
incl %edi # increment sp
movl %eax, stack(,%edi,4) # write constant onto stack
incl %esi # other half of pc += 2
jmp .EndOfSwitch

.addi
movl %eax, stack(,%edi,4) # load first operand
decl %edi # sp -= 1;
addl stack(,%edi,4), %eax # add
incl %esi # pc += 1;
jmp .EndOfSwitch