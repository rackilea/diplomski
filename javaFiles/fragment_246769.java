template <typename T>
struct templ {
   template <typename U, typename _ = std::enable_if< 
                              typename std::is_base_of<U,T>::value
                                       >::type >
   void super( templ<U> & u );       // public void super_<? super T>( templ<?> u )

   template <typename U, typename _ = std::enable_if<
                              typename std::is_base_of<T,U>::value 
                                       >::type >
   void extends( templ<U> & u );     // public void extends_<? extends T>( templ<?> u )
}