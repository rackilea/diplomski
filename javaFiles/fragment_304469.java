@XmlRootElement
class WxPayOrder() { // actually now this line contains the no-arg constructor
   // your properties
   lateinit var demo : String
   // your custom constructors
   constructor(demo : String) : this() {
     this.demo = demo
   }
}