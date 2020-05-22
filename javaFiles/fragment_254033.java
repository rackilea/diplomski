void bind(Member member) {
    if(this.member != null) {
        this.member.removeAllChangeListeners();
    }
    this.member = member;
    this.member.addChangeListener(...);