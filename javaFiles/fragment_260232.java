class Outer {
   object Inner {
      def apply() = new Inner()
   }
   class Inner
}

new Outer().Inner()