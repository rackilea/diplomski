class A {
        @Column(name = "a_id")
        Integer id;

        @OneToMany(mappedBy = "a", cascade = CascadeType.ALL)
        private List<B> listOfB = new ArrayList<B>;

        public void addB(B b) {
           b.setA(this); 
           listOfB.add(b);
        }
    }

    class B {
        Integer id;
        String name;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "a_id")
        private A a;
    }