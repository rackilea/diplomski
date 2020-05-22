class UseBeforeDeclaration {

    {
        j = 200;
          // ok - assignment
        j = j + 1;
          // error - right hand side reads before declaration
        int k = j = j + 1;
          // error - illegal forward reference to j
        int n = j = 300;
          // ok - j at left hand side of assignment
        int h = j++;
          // error - read before declaration
        int l = this.j * 3;
          // ok - not accessed via simple name
    }

    int j;
}