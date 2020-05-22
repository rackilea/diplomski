%javamethodmodifiers MapIterator::nextImpl "private";
%inline %{
  struct MapIterator {
    typedef std::map<int,std::string> map_t;
    MapIterator(const map_t& m) : it(m.begin()), map(m) {}
    bool hasNext() const {
      return it != map.end();
    }

    const std::string& nextImpl() {
      const std::pair<int,std::string>& ret = *it++;
      return ret.second;
    }
  private:
    map_t::const_iterator it;
    const map_t& map;    
  };
%}