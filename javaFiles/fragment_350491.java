struct apr_pollfd_t {
    apr_pool_t *p;              /**< associated pool */
    apr_datatype_e desc_type;   /**< descriptor type */
    apr_int16_t reqevents;      /**< requested events */
    apr_int16_t rtnevents;      /**< returned events */
    apr_descriptor desc;        /**< @see apr_descriptor */
    void *client_data;          /**< allows app to associate context */
};