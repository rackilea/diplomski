struct printer {
    using result_type = void;
    std::ostream& _os;
    std::string _indent = "";

    template <typename... Ts> void operator()(boost::variant<Ts...> const& v) const {
        return boost::apply_visitor(*this, v);
    }

    void operator()(int i) const                { _os << i;              } 
    void operator()(std::string const &s) const { _os << std::quoted(s); } 

    template <typename... Ts> void operator()(std::vector<Ts...> const& v) const {
        _os << "[";
        auto indent = _indent + "    ";

        bool first = true;
        for (auto& el : v) {
            if (first) first = false;
            else _os << ",";
            _os << "\n" << indent;
            printer{_os, indent}(el);
        }

        if (!v.empty())
            _os << "\n" << _indent;
        _os << "]";
    }
};