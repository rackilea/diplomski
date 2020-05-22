export default {
    data: () => ({
      showNav: false,
    }),
    methods: {
      toggleNav: () => {
        this.showNav = !this.showNav
        console.log(this)
      }
    }
}