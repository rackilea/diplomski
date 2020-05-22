import os
  import time
  aditya = True
  while aditya:
      os.system("cls")
      print("Enter a program name to execute:")
      name = input()
      os.system("cd C:\\Program Files\\Java\\jdk-13.0.1\\bin")
  """Note : Code works without above statement(cd path)because it does nothing since 
   we are in same directory."""
     time.sleep(0.5)
     os.system(f"javac {name}.java")
     os.system(f"java {name}")
     key = input()