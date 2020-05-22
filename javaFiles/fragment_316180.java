class Thing {
  public:
    static std::string createUniqueId () {
        boost::unique_lock<boost::mutex> synchronized(mutex_);
        // ... generate a unique id here.
    }

  protected:
    static boost::mutex mutex_;
};