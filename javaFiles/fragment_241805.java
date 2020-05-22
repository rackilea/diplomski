import sys
import time

sys.stdout.write("give some input: ")
sys.stdout.flush()
time.sleep(2)
line = sys.stdin.readline()
sys.stdout.write("you typed: " + line)
sys.stdout.flush();