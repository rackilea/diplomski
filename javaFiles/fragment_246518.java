/**
 * This is a special List class used with LUA which tells LUA what the types of objects in its list must be instances of.
 * Otherwise, when updating a list in LUA, whatever is the first object in a list is what all other objects must be an instance of.
 */
public interface TypedList {
    Class GetListClass();
}