export default {
    data() {                                   // <== changed this line
      showNav: false,
    },
    methods: {
      toggleNav() {                            // <== changed this line
        this.showNav = !this.showNav
        console.log(this)
      }
    }
}