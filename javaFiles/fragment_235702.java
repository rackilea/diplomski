@Entity
public class A {
    @Id
    private Integer id;

    @OneToOne(mappedBy = "a")
    private B b;
}

@Entity
public class B {
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "a_id")
    private A a;

}

mysql> desc A;
+-------+---------+------+-----+---------+-------+
| Field | Type    | Null | Key | Default | Extra |
+-------+---------+------+-----+---------+-------+
| id    | int(11) | NO   | PRI | NULL    |       |
+-------+---------+------+-----+---------+-------+
1 row in set (0.00 sec)

mysql> desc B;
+-------+---------+------+-----+---------+-------+
| Field | Type    | Null | Key | Default | Extra |
+-------+---------+------+-----+---------+-------+
| id    | int(11) | NO   | PRI | NULL    |       |
| a_id  | int(11) | YES  | MUL | NULL    |       |
+-------+---------+------+-----+---------+-------+