//use existing getMetaFromState
@Override
public IBlockState getStateFromMeta(int meta)
{
    return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
}