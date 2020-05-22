public override int GetHashCode()
{
  unchecked // integer overflows are accepted here
  {
    int hashCode = 0;
    hashCode = (hashCode * 397) ^ this.Hue.GetHashCode();
    hashCode = (hashCode * 397) ^ this.Saturation.GetHashCode();
    hashCode = (hashCode * 397) ^ this.Luminance.GetHashCode();
    return hashCode;
  }
}