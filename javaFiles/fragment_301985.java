public static void main(String[] args) {
    Outer obj = new Outer2();  // Step 1
    obj.new In();              // Step 2
    Outer2 in2 = (Outer2) obj; // Step 3
    in2.new In();              // Step 4
 }