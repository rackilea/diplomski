inline valType roll
(
    detail::tquat<valType> const & q
)
{
    return atan2(valType(2) * (q.x * q.y + q.w * q.z), q.w * q.w + q.x * q.x - q.y * q.y - q.z * q.z);
}

template <typename valType> 
inline valType pitch
(
    detail::tquat<valType> const & q
)
{
    return atan2(valType(2) * (q.y * q.z + q.w * q.x), q.w * q.w - q.x * q.x - q.y * q.y + q.z * q.z);
}

template <typename valType> 
inline valType yaw
(
    detail::tquat<valType> const & q
)
{
    return asin(valType(-2) * (q.x * q.z - q.w * q.y));
}