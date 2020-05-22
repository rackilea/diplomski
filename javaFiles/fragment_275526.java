class D {
    private A a;
    private B b;
}

<mapping>
  <class-a>D</class-a>
  <class-b>C</class-b>
  <field>
    <a>a.a</a>
    <b>a</b>
  </field>
  <field>
    <a>a.b</a>
    <b>b</b>
  </field>
  <field>
    <a>b.c</a>
    <b>c</b>
  </field>
</mapping>