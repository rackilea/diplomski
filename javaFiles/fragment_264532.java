template < typename Key, typename Value, typename Compare, typename Alloc >
auto lowerEntry(std::map<Key, Value, Compare, Alloc> map, Key key) -> decltype(map.begin()) {
    auto iter = map.lower_bound(key); // find the first element to go at or after key
    if(iter == map.begin()) // all elements go after key
        return map.end(); // signals that no lowerEntry could be found
    return --iter; // pre-decrement to return an iterator to the element before iter
}