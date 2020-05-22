@Table(
        name = "table2",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "salesman"),
                @UniqueConstraint(columnNames = "product"),
                @UniqueConstraint(columnNames = "priorityTarget")
        }
)