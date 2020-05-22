new Vue({
 el: "#app",
  data: {
   input_h: 0,
   input_m: 0,
   input_t: 0
  },
  methods: {
  update_h (e) {
   this.input_h = Number(e.target.value)
    this.update_t(null)
  },
  update_m (e) {
   this.input_m = Number(e.target.value)
    this.update_t(null)
  },
  update_t (e) {
   if (e === null) {
     this.input_t = Math.round((this.input_h + this.input_m / 60) * 100)/100
    } else {
     this.input_t = Number(e.target.value)
      this.input_h = Math.floor(this.input_t)
      this.input_m = Math.round(this.input_t%1 * 60)
    }
    
  },
  }
})