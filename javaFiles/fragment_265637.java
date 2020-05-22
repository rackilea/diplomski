@OneToOne
    @JoinColumn(
            foreignKey=@ForeignKey(
                    foreignKeyDefinition="FOREIGN KEY (ref2a) REFERENCES A (id) ON DELETE CASCADE"
                    )
            )
    private A ref2a;