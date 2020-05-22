class GameObject {
};

class CollisionListener {
public:
    virtual bool collidedWith(GameObject &) { return false; }
    virtual ~CollisionListener() {} 
};

inline void makeCall(GameObject& o, CollisionListener& c) {
    c.collidedWith(o);
}