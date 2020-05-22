//remove this
        @Column(name="profile_id") 
        protected Integer profileId;    

       @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
       protected User user;  

    //add this 
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "profile_id", nullable = false)
        protected User user;